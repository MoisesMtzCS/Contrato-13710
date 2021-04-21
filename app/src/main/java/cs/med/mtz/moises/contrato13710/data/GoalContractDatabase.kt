package cs.med.mtz.moises.contrato13710.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import cs.med.mtz.moises.contrato13710.data.converter.DateConverter
import cs.med.mtz.moises.contrato13710.data.dao.ContractDao
import cs.med.mtz.moises.contrato13710.data.dao.GoalDao
import cs.med.mtz.moises.contrato13710.data.dto.ContractDto
import cs.med.mtz.moises.contrato13710.data.dto.GoalDto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

@Database(
    entities = [
        GoalDto::class,
        ContractDto::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class GoalContractDatabase : RoomDatabase() {

    /** */
    abstract fun goalDao(): GoalDao

    /** */
    abstract fun contractDao(): ContractDao

    /** */
    private class GoalContractDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {
                    val goalDao = database.goalDao()
                    val contractDao = database.contractDao()

                    val goal = GoalDto("Agua")
                    val goalId: Long = goalDao.insert(goal)
                    val contractDto = ContractDto(goalId.toInt(), "Tomar dos vasos de agua.", 1, Date())
                    contractDao.insert(contractDto)

                }
            }
        }
    }

    /** */
    companion object {

        @Volatile
        private var INSTANCE: GoalContractDatabase? = null

        /** */
        fun getDatabase(context: Context, scope: CoroutineScope): GoalContractDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GoalContractDatabase::class.java,
                    "contract_database"
                )
                    .addCallback(GoalContractDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

}