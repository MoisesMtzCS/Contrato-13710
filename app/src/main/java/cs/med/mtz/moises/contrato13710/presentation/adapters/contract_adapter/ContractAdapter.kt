package cs.med.mtz.moises.contrato13710.presentation.adapters.contract_adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import cs.med.mtz.moises.contrato13710.databinding.ViewHolderContractBinding
import cs.med.mtz.moises.contrato13710.domain.entity.Contract
import cs.med.mtz.moises.contrato13710.presentation.contract_details.ContractDetailsActivity

class ContractAdapter(
    private val contracts: List<Contract>
) : RecyclerView.Adapter<ContractAdapter.ContractViewHolder>() {

    class ContractViewHolder(
        val binding: ViewHolderContractBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContractViewHolder {
        val context = parent.context
        val layoutInflater = LayoutInflater.from(context)
        val binding = ViewHolderContractBinding.inflate(layoutInflater, parent, false)
        return ContractViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return contracts.size
    }


    override fun onBindViewHolder(holder: ContractViewHolder, position: Int) {
        val contract: Contract = contracts[position]
        //holder.binding.tvTitle.text = contract.id.toString

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context,ContractDetailsActivity::class.java).apply {
                putExtra("TARGET", contract.target)
            }
            ContextCompat.startActivity(context, intent, null)
        }

    }


}