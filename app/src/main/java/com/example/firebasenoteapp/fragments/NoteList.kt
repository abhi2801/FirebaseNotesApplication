package com.example.firebasenoteapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.firebasenoteapp.R
import com.example.firebasenoteapp.databinding.FragmentNoteListBinding
import com.google.firebase.firestore.FirebaseFirestore

class NoteList : Fragment() {
    private lateinit var binding: FragmentNoteListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentNoteListBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val user:MutableMap<String,Any> =HashMap()
        user["first"]="Abhishek"
        user["last"]="Nayak"
        user["desig"]="Android Developer"
        user["location"]="Odisha"
        FirebaseFirestore.getInstance().collection("users")
            .add(user)
            .addOnSuccessListener {
                Log.d("done","Document Added : ${it.id}")
            }
            .addOnFailureListener {
                Log.d("fail","Failed : ${it.message}")
            }
    }
}