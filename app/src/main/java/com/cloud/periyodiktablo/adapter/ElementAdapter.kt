package com.cloud.periyodiktablo.adapter


import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cloud.periyodiktablo.model.ElementModel
import com.cloud.periyodiktablo.R
import com.cloud.periyodiktablo.databinding.CustomAlertDialogBinding
import com.cloud.periyodiktablo.databinding.ItemLayoutBinding

class ElementAdapter(private val elementList: List<ElementModel>) :
    RecyclerView.Adapter<ElementAdapter.ElementViewHolder>() {
    inner class ElementViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(element: ElementModel) {
            if (element.isVisible) {
                binding.element = element
            } else {
                binding.cvItem.visibility = View.GONE
                binding.cvItem.isEnabled = false
            }
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutBinding.inflate(inflater, parent, false)
        return ElementViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ElementViewHolder, position: Int) {
        holder.bind(elementList[position])

        holder.itemView.setOnClickListener {
            val alertBinding  = DataBindingUtil.inflate<CustomAlertDialogBinding>(LayoutInflater.from(it.context),
                R.layout.custom_alert_dialog,null,false)
            val customAlertDialog = AlertDialog.Builder(it.context)
            alertBinding.adElement = elementList[position]
            customAlertDialog.setView(alertBinding.root).show()
            alertBinding.ivElementImage.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }
        }
    }

    override fun getItemCount(): Int {
        return elementList.size
    }
}