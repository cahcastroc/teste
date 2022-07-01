package br.edu.infnet.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import br.edu.infnet.todo.databinding.FragmentIntroBinding

class IntroFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_intro, container, false)

        val userName = view.findViewById<EditText>(R.id.etUserName)
        val start_button = view.findViewById<Button>(R.id.start_button)
        val about_button = view.findViewById<Button>(R.id.about_button)




       start_button.setOnClickListener {
           val bundle = Bundle()
           bundle.putString("name",userName.text.toString())
           findNavController().navigate(R.id.action_introFragment_to_mainActivity2, bundle)

           }


       about_button.setOnClickListener {

             findNavController().navigate(R.id.action_introFragment_to_aboutFragment)
        }



        return view   }





}