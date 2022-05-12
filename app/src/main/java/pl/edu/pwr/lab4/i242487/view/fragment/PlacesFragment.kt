package pl.edu.pwr.lab4.i242487.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import pl.edu.pwr.lab4.i242487.databinding.FragmentPlacesBinding
import pl.edu.pwr.lab4.i242487.model.Place
import pl.edu.pwr.lab4.i242487.model.dummyData.RomeCityData
import pl.edu.pwr.lab4.i242487.view.activity.PlaceActivity
import pl.edu.pwr.lab4.i242487.view.adapter.ModuleRecyclerViewAdapter

class PlacesFragment : Fragment() {

    private var _binding: FragmentPlacesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlacesBinding.inflate(inflater, container, false)

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val placesAdapter = ModuleRecyclerViewAdapter(requireContext()).apply {
            itemList(RomeCityData.places())
            onItemClick = {
                item -> val intent = Intent(context, PlaceActivity::class.java).apply{
                    putExtra(PlaceActivity.BUNDLE_KEY_PLACE, item as Place)
                }
                startActivity(intent)
            }
        }

        mBinding.rvPlacesList.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = placesAdapter
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}