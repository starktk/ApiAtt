package br.com.fundatec.fundatecheroesti21.character.view

import androidx.recyclerview.widget.RecyclerView
import br.com.fundatec.fundatecheroesti21.character.data.remote.CharacterModel
import br.com.fundatec.fundatecheroesti21.databinding.CharacterListItemBinding
import com.bumptech.glide.Glide

class
CharacterViewHolder(private val binding: CharacterListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(character: CharacterModel) {
        binding.tvName.text = character.name
        Glide.with(binding.root.context)
            .load(character.url)
            .into(binding.imgHeroe)
    }
}