package com.example.android.moneyloverclon

import androidx.room.Room
import androidx.room.Transaction
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.android.moneyloverclon.data.database.FinancialDatabase
import com.example.android.moneyloverclon.data.database.dao.TransactionsDao
import com.example.android.moneyloverclon.data.database.entities.TransactionsEntity
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import java.io.IOException

/**
 ** Created by Carlos A. Novaez Guerrero on 04/12/2022 13:31
 ** cnovaez.dev@outlook.com
 **/
@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class FinancialDatabaseTests {
    private lateinit var transactionsDao: TransactionsDao
    private lateinit var db: FinancialDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, FinancialDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        transactionsDao = db.transactionsDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }
//
//    @Test
//    @Throws(Exception::class)
//    fun insertTransaction() {
//        val trans = TransactionsEntity();
//        trans.description = "Tests description"
//        trans.title = "Test Title";
//        transactionsDao.insertTransaction(trans)
//        val neo = transactionsDao.getLastCreatedTransactions();
//        println("Description: ${neo!!.description} title: ${neo.title} id: ${neo.id}")
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun updateTransaction() {
//        val trans = TransactionsEntity();
//        trans.description = "Tests description"
//        trans.title = "Test Title";
//        trans.quantity = 345.211
//        transactionsDao.insertTransaction(trans)
//        val neo = transactionsDao.getLastCreatedTransactions();
//        println("Description: ${neo!!.description} title: ${neo.title} id: ${neo.id} quantity: ${neo.quantity}")
//        neo.title ="New Title"
//        neo.description = "New Description"
//        neo.quantity = 100.0
//        transactionsDao.updateTransaction(neo)
//        val neo2 = transactionsDao.getLastCreatedTransactions();
//        println("Description: ${neo2!!.description} title: ${neo2.title} id: ${neo2.id} quantity: ${neo2.quantity}")
//        Assert.assertEquals(neo.id, neo2.id)
//    }
//    @Test
//    @Throws(Exception::class)
//    fun deleteTransaction() {
//        val trans = TransactionsEntity();
//        trans.description = "Tests description"
//        trans.title = "Test Title";
//        trans.quantity = 345.211
//        transactionsDao.insertTransaction(trans)
//        val neo = transactionsDao.getLastCreatedTransactions();
//        println("Description: ${neo!!.description} title: ${neo.title} id: ${neo.id} quantity: ${neo.quantity}")
//        transactionsDao.deleteTransactionById(neo.id)
//        val res = transactionsDao.getLastCreatedTransactions();
//
//        Assert.assertEquals(res, null)
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun getAllTransactions() {
//        for(i in 0..5){
//            val trans = TransactionsEntity();
//            transactionsDao.insertTransaction(trans)
//        }
//        val list = transactionsDao.getAllTransactions()
//        print("List size: ${list.size}")
//        Assert.assertEquals(list.size, 6)
//
//        transactionsDao.emptyTransactionsTable()
//val value = transactionsDao.getAllTransactions()
//        Assert.assertEquals(value, emptyList<TransactionsEntity>())
//    }
}