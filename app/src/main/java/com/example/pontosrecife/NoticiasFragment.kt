package com.example.pontosrecife

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.pontosrecife.databinding.FragmentNoticiasBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class NoticiasFragment : Fragment() {
    /*
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_us, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AboutUsAllFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AboutUsAllFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentNoticiasBinding>(inflater,
                R.layout.fragment_noticias,container,false)

        binding.link1.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_noticiasFragment_to_noticia1Fragment)
        }
        binding.link2.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_noticiasFragment_to_noticia2Fragment)
        }
        binding.link3.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_noticiasFragment_to_noticia3Fragment)
        }
        binding.link4.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_noticiasFragment_to_noticiaPlaceholderFragment)
        }
        binding.link5.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_noticiasFragment_to_noticiaPlaceholderFragment)
        }
        binding.link6.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_noticiasFragment_to_noticiaPlaceholderFragment)
        }
        binding.link7.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_noticiasFragment_to_noticiaPlaceholderFragment)
        }
        binding.link8.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_noticiasFragment_to_noticiaPlaceholderFragment)
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,requireView().findNavController())
                ||super.onOptionsItemSelected(item)
    }

}