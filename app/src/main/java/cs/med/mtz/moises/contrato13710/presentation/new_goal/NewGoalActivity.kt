package cs.med.mtz.moises.contrato13710.presentation.new_goal

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cs.med.mtz.moises.contrato13710.databinding.ActivityNewGoalBinding
import cs.med.mtz.moises.contrato13710.presentation.goal_holders.GoalItemsActivity
import org.koin.android.viewmodel.ext.android.viewModel

class NewGoalActivity : AppCompatActivity() {


    private val nameGoal: String
        get() = binding.nameGoal.text.toString()

    private val target: String
        get() = binding.target.text.toString()

    /** */

    private val newGoalViewModel: NewGoalViewModel by viewModel()

    /** */

    private val binding: ActivityNewGoalBinding by lazy {
        ActivityNewGoalBinding.inflate(layoutInflater)
    }

    /** */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        execute()
    }

    /** */

    private fun execute() {
        createGoalAndContractClickListener()
    }

    private fun createGoalAndContractClickListener() {
        binding.save.setOnClickListener {
            if (nameGoal.isNotBlank() && target.isNotBlank()) {
                newGoalViewModel.createGoalFullLiveData(nameGoal, target).observe(this) {}
                val intent = Intent(this, GoalItemsActivity::class.java)
                startActivity(intent)
                finish()
            } else Toast.makeText(this, "Datos Incompletos", Toast.LENGTH_SHORT).show()
        }
    }


}

