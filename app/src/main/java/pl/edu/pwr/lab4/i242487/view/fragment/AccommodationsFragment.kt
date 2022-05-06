package pl.edu.pwr.lab4.i242487.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import pl.edu.pwr.lab4.i242487.databinding.FragmentAccommodationsBinding

class AccommodationsFragment : Fragment(){

    private var _binding: FragmentAccommodationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAccommodationsBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}