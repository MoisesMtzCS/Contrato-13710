package cs.med.mtz.moises.contrato13710.presentation.adapters.goal_adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import cs.med.mtz.moises.contrato13710.databinding.ViewHolderGoalBinding
import cs.med.mtz.moises.contrato13710.domain.entity.Goal
import cs.med.mtz.moises.contrato13710.presentation.contract_items.ContractItemsActivity


class GoalAdapter(
    private val goals: List<Goal>
) : RecyclerView.Adapter<GoalAdapter.GoalViewHolder>() {

    class GoalViewHolder(
        val binding: ViewHolderGoalBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalViewHolder {
        val context = parent.context
        val layoutInflater = LayoutInflater.from(context)
        val binding = ViewHolderGoalBinding.inflate(layoutInflater, parent, false)
        return GoalViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return goals.size
    }

    override fun onBindViewHolder(holder: GoalViewHolder, position: Int) {
        val goal: Goal = goals[position]
        holder.binding.tvTitle.text = goal.name

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ContractItemsActivity::class.java).apply {
                putExtra("ID", goal.id)
                putExtra("NAME", goal.name)
            }
            ContextCompat.startActivity(context, intent, null)
           // (context as Activity).finish()

        }

    }


}