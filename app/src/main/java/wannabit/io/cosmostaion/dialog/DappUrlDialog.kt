package wannabit.io.cosmostaion.dialog

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import wannabit.io.cosmostaion.R
import wannabit.io.cosmostaion.databinding.DialogDappUrlBinding

class DappUrlDialog(val url: String, val listener: UrlListener) : DialogFragment() {
    private var _binding: DialogDappUrlBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DialogDappUrlBinding.inflate(inflater, container, false)
        settingViews()
        binding.url.setText(url)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.url.clearFocus()
        binding.url.requestFocus()
        binding.url.postDelayed({
            val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(binding.url, 0)
        }, 250)
    }

    private fun settingViews() {
        dialog?.window?.setBackgroundDrawableResource(R.color.colorTrans)
        binding.dimmedWrap.setOnClickListener { dismiss() }
        binding.url.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (!TextUtils.isEmpty(binding.url.text.toString())) {
                    binding.url.background = ContextCompat.getDrawable(requireActivity(), R.drawable.box_vote_voted)
                } else {
                    binding.url.background = ContextCompat.getDrawable(requireActivity(), R.drawable.box_round_unselected)
                }
            }
        })
        binding.url.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                listener.input(binding.url.text.toString())
                dismiss()
            }
            false
        }
    }

    interface UrlListener {
        fun input(url: String)
    }

    companion object {
        fun newInstance(url: String, listener: UrlListener): DappUrlDialog {
            val dialog = DappUrlDialog(url, listener)
            dialog.isCancelable = true
            return dialog
        }
    }
}