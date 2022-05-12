package pl.edu.pwr.lab4.i242487.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import pl.edu.pwr.lab4.i242487.databinding.FragmentEventsBinding
import pl.edu.pwr.lab4.i242487.model.Event
import pl.edu.pwr.lab4.i242487.model.dummyData.RomeCityData
import pl.edu.pwr.lab4.i242487.view.activity.EventActivity
import pl.edu.pwr.lab4.i242487.view.adapter.ModuleRecyclerViewAdapter

class EventsFragment : Fragment() {

    private var _binding: FragmentEventsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentEventsBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val accommodationsAdapter = ModuleRecyclerViewAdapter(requireContext()).apply {
            itemList(RomeCityData.events())
            onItemClick = {
                val intent = Intent(context, EventActivity::class.java).apply{
                    putExtra(EventActivity.BUNDLE_KEY_EVENT, it as Event)
                }
                startActivity(intent)
            }
        }

        mBinding.rvEventsList.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = accommodationsAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}