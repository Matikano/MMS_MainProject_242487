package pl.edu.pwr.lab4.i242487.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import pl.edu.pwr.lab4.i242487.databinding.FragmentTourGuidesBinding
import pl.edu.pwr.lab4.i242487.model.RomeCityData
import pl.edu.pwr.lab4.i242487.view.activity.TourGuideActivity
import pl.edu.pwr.lab4.i242487.view.adapter.TourAdapter

class TourGuidesFragment : Fragment() {

    private var _binding: FragmentTourGuidesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTourGuidesBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tourAdapter = TourAdapter(this@TourGuidesFragment).apply {
            tourList(RomeCityData.tours())
            onItemClick = { tour ->
                val intent = Intent(context, TourGuideActivity::class.java).apply{
                    putExtra(TourGuideActivity.BUNDLE_KEY_TOUR_GUIDE, tour)
                }

                startActivity(intent)
            }
        }

        mBinding.rvTourGuides.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = tourAdapter
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}