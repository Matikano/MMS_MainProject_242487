package pl.edu.pwr.lab4.i242487.view.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.Toast
import androidx.core.app.DialogCompat
import androidx.fragment.app.DialogFragment
import pl.edu.pwr.lab4.i242487.R
import pl.edu.pwr.lab4.i242487.databinding.ReviewDialogBinding

class ReviewDialogFragment(val title: String) : DialogFragment() {

    companion object{
        const val TAG = "ReviewDialogFragment"
    }

    private lateinit var mBinding: ReviewDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = ReviewDialogBinding.inflate(inflater)

        mBinding.tvTitle.text = title

        setButtonListeners()

        return mBinding.root
    }

    private fun setButtonListeners() {
        mBinding.bCancel.setOnClickListener {
            dialog?.cancel()
        }

        mBinding.bSubmit.setOnClickListener {
            if(mBinding.rbRating.rating > 0) {
                dialog?.cancel()
                Toast.makeText(context, R.string.review_submission, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, R.string.review_choose_rating, Toast.LENGTH_SHORT).show()
            }
        }
    }
}