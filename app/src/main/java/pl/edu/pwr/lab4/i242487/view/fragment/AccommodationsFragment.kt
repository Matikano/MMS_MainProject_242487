package pl.edu.pwr.lab4.i242487.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import pl.edu.pwr.lab4.i242487.databinding.FragmentAccommodationsBinding
import pl.edu.pwr.lab4.i242487.model.Accommodation
import pl.edu.pwr.lab4.i242487.model.dummyData.RomeCityData
import pl.edu.pwr.lab4.i242487.view.activity.AccommodationActivity
import pl.edu.pwr.lab4.i242487.view.adapter.ModuleRecyclerViewAdapter

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val accommodationsAdapter = ModuleRecyclerViewAdapter(requireContext()).apply {
            itemList(RomeCityData.accommodations())
            onItemClick = {
                val intent = Intent(context, AccommodationActivity::class.java).apply{
                        putExtra(AccommodationActivity.BUNDLE_KEY_ACCOMMODATION, it as Accommodation)
                }
                startActivity(intent)
            }
        }

        mBinding.rvAccommodationsList.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = accommodationsAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}