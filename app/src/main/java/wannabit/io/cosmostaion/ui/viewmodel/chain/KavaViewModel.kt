package wannabit.io.cosmostaion.ui.viewmodel.chain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cosmos.base.v1beta1.CoinProto
import com.kava.cdp.v1beta1.QueryProto.QueryCdpsResponse
import com.kava.cdp.v1beta1.QueryProto.QueryParamsResponse
import com.kava.hard.v1beta1.HardProto
import com.kava.hard.v1beta1.QueryProto.MoneyMarketInterestRate
import com.kava.hard.v1beta1.QueryProto.QueryBorrowsResponse
import com.kava.hard.v1beta1.QueryProto.QueryDepositsResponse
import com.kava.hard.v1beta1.QueryProto.QueryInterestRateResponse
import com.kava.hard.v1beta1.QueryProto.QueryTotalBorrowedResponse
import com.kava.hard.v1beta1.QueryProto.QueryTotalDepositedResponse
import com.kava.incentive.v1beta1.QueryProto
import com.kava.pricefeed.v1beta1.QueryProto.QueryPricesResponse
import io.grpc.ManagedChannel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import wannabit.io.cosmostaion.data.model.res.NetworkResult
import wannabit.io.cosmostaion.data.repository.chain.KavaRepository

class KavaViewModel(private val kavaRepository: KavaRepository) : ViewModel() {

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    private var _incentiveResult = MutableLiveData<QueryProto.QueryRewardsResponse?>()
    val incentiveResult: LiveData<QueryProto.QueryRewardsResponse?> get() = _incentiveResult
    fun incentive(managedChannel: ManagedChannel, address: String?) = CoroutineScope(Dispatchers.IO).launch {
        when (val response = kavaRepository.incentive(managedChannel, address)) {
            is NetworkResult.Success -> {
                _incentiveResult.postValue(response.data)
            }

            is NetworkResult.Error -> {
                _errorMessage.postValue("error type : ${response.errorType}  error message : ${response.errorMessage}")
            }
        }
    }

    private var _priceFeedResult = MutableLiveData<QueryPricesResponse?>()
    val priceFeedResult: LiveData<QueryPricesResponse?> get() = _priceFeedResult
    fun priceFeed(managedChannel: ManagedChannel) = CoroutineScope(Dispatchers.IO).launch {
        when (val response = kavaRepository.priceFeed(managedChannel)) {
            is NetworkResult.Success -> {
                _priceFeedResult.postValue(response.data)
            }

            is NetworkResult.Error -> {
                _errorMessage.postValue("error type : ${response.errorType}  error message : ${response.errorMessage}")
            }
        }
    }

    private var _mintParamResult = MutableLiveData<QueryParamsResponse?>()
    val mintParamResult: LiveData<QueryParamsResponse?> get() = _mintParamResult
    fun mintParam(managedChannel: ManagedChannel) = CoroutineScope(Dispatchers.IO).launch {
        when (val response = kavaRepository.mintParam(managedChannel)) {
            is NetworkResult.Success -> {
                _mintParamResult.postValue(response.data)
            }

            is NetworkResult.Error -> {
                _errorMessage.postValue("error type : ${response.errorType}  error message : ${response.errorMessage}")
            }
        }
    }

    private var _myCdpResult = MutableLiveData<QueryCdpsResponse?>()
    val myCdpResult: LiveData<QueryCdpsResponse?> get() = _myCdpResult
    fun myCdp(managedChannel: ManagedChannel, address: String?) = CoroutineScope(Dispatchers.IO).launch {
        when (val response = kavaRepository.myCdp(managedChannel, address)) {
            is NetworkResult.Success -> {
                _myCdpResult.postValue(response.data)
            }

            is NetworkResult.Error -> {
                _errorMessage.postValue("error type : ${response.errorType}  error message : ${response.errorMessage}")
            }
        }
    }


    private val _lendingData = MutableLiveData<LendingData?>()
    val lendingData: LiveData<LendingData?> get() = _lendingData
    fun lendingData(managedChannel: ManagedChannel, address: String?) {
        CoroutineScope(Dispatchers.IO).launch {
            val lendingParamDeferred = async { kavaRepository.lendingParam(managedChannel) }
            val interestRateDeferred = async { kavaRepository.lendingRate(managedChannel) }
            val totalDepositDeferred = async { kavaRepository.lendingTotalDeposit(managedChannel) }
            val totalBorrowDeferred = async { kavaRepository.lendingTotalBorrow(managedChannel) }
            val myDepositDeferred = async { kavaRepository.lendingMyDeposit(managedChannel, address) }
            val myBorrowDeferred = async { kavaRepository.lendingMyBorrow(managedChannel, address) }

            val responses = awaitAll(lendingParamDeferred, interestRateDeferred, totalDepositDeferred, totalBorrowDeferred, myDepositDeferred, myBorrowDeferred)

            var lendingParam: HardProto.Params? = null
            var lendingRates: MutableList<MoneyMarketInterestRate>? = mutableListOf()
            var lendingTotalDeposits: MutableList<CoinProto.Coin>? = mutableListOf()
            var lendingTotalBorrows: MutableList<CoinProto.Coin>? = mutableListOf()
            var lendingMyDeposits: MutableList<com.kava.hard.v1beta1.QueryProto.DepositResponse>? = mutableListOf()
            var lendingMyBorrows: MutableList<com.kava.hard.v1beta1.QueryProto.BorrowResponse>? = mutableListOf()

            responses.forEach { response ->
                when (response) {
                    is NetworkResult.Success -> {
                        when (response.data) {
                            is com.kava.hard.v1beta1.QueryProto.QueryParamsResponse -> {
                                response.data.params?.let { lendingParam = it }
                            }

                            is QueryInterestRateResponse -> {
                                response.data.interestRatesList?.let { lendingRates = it }
                            }

                            is QueryTotalDepositedResponse -> {
                                response.data.suppliedCoinsList?.let { lendingTotalDeposits = it }
                            }

                            is QueryTotalBorrowedResponse -> {
                                response.data.borrowedCoinsList?.let { lendingTotalBorrows = it }
                            }

                            is QueryDepositsResponse -> {
                                response.data.depositsList?.let { lendingMyDeposits = it }
                            }

                            is QueryBorrowsResponse -> {
                                response.data.borrowsList?.let { lendingMyBorrows = it }
                            }
                        }
                        _lendingData.postValue(LendingData(lendingParam, lendingRates, lendingTotalDeposits, lendingTotalBorrows, lendingMyDeposits, lendingMyBorrows))
                    }

                    is NetworkResult.Error -> {
                        _errorMessage.postValue("error type : ${response.errorType}  error message : ${response.errorMessage}")
                    }
                }
            }
        }
    }
}

data class LendingData(
    var lendingParam: HardProto.Params?,
    val lendingRates: MutableList<MoneyMarketInterestRate>?,
    val lendingTotalDeposits: MutableList<CoinProto.Coin>?,
    val lendingTotalBorrows: MutableList<CoinProto.Coin>?,
    val lendingMyDeposits: MutableList<com.kava.hard.v1beta1.QueryProto.DepositResponse>?,
    val lendingMyBorrows: MutableList<com.kava.hard.v1beta1.QueryProto.BorrowResponse>?
)