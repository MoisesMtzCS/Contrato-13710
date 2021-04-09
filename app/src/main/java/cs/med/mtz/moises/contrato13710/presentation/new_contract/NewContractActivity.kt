package cs.med.mtz.moises.contrato13710.presentation.new_contract

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cs.med.mtz.moises.contrato13710.R
import cs.med.mtz.moises.contrato13710.databinding.ActivityNewContractBinding
import cs.med.mtz.moises.contrato13710.presentation.goal_items.GoalItemsActivity
import org.koin.android.viewmodel.ext.android.viewModel

class NewContractActivity : AppCompatActivity() {

    /** */
    private val newContractViewModel: NewContractViewModel by viewModel()

    /** */

    val target: String
        get() = binding.target.text.toString()

    /** */

    val binding: ActivityNewContractBinding by lazy {
        ActivityNewContractBinding.inflate(layoutInflater)
    }

    /** */
    private val contractId: Int by lazy { intent.extras!!.getInt("ID") }

    /** */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        createContractClickListener()
        // execute()
    }


    private fun createContractClickListener() {
        binding.saveButton.setOnClickListener {
            if (target.isNotBlank()) {
                newContractViewModel.newContractLiveData(contractId, target).observe(this) {}
                startActivity(Intent(this, GoalItemsActivity::class.java))
                finish()
            } else alertIncompleteData()
        }
    }

    private fun alertIncompleteData() {
        val builder = AlertDialog.Builder(this)
            .setTitle(getString(R.string.incomplete_data))
            .setNegativeButton("aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}