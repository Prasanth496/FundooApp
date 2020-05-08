package com.example.fundooapp.model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DatabaseHelper constructor(context: Context?) :
    SQLiteOpenHelper(
        context,
        DATABASE_NAME,
        null,
        DATABASE_VERSION
    ) {
    // create table sql query
    private val CREATE_USER_TABLE =
        ("CREATE TABLE " + TABLE_USER + "("
                + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
                + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")")
    // drop table sql query
    private val DROP_USER_TABLE =
        "DROP TABLE IF EXISTS $TABLE_USER"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_USER_TABLE)
    }

    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) { //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE)
        // Create tables again
        onCreate(db)
    }

    fun addUser(user: User) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_USER_NAME, user.userName)
        values.put(COLUMN_USER_EMAIL, user.email)
        values.put(COLUMN_USER_PASSWORD, user.password)
        // Inserting Row
        db.insert(TABLE_USER, null, values)
        db.close()
    }

    fun checkUser(email: String): Boolean { // array of columns to fetch
        val columns = arrayOf(
            COLUMN_USER_ID
        )
        val db = this.readableDatabase
        // selection criteria
        val selection = "$COLUMN_USER_EMAIL = ?"
        // selection argument
        val selectionArgs = arrayOf(email)
        val cursor = db.query(
            TABLE_USER,  //Table to query
            columns,  //columns to return
            selection,  //columns for the WHERE clause
            selectionArgs,  //The values for the WHERE clause
            null,  //group the rows
            null,  //filter by row groups
            null
        ) //The sort order
        val cursorCount = cursor.count
        cursor.close()
        db.close()
        return if (cursorCount > 0) {
            true
        } else false
    }

    fun checkUser(
        email: String,
        password: String
    ): Boolean { // array of columns to fetch
        val columns =
            arrayOf(COLUMN_USER_ID)
        val db = this.readableDatabase
        val selection =
            "$COLUMN_USER_EMAIL = ? AND $COLUMN_USER_PASSWORD = ?"
        val selectionArgs = arrayOf(email, password)
        val cursor = db.query(
            TABLE_USER,  //Table to query
            columns,  //columns to return
            selection,  //columns for the WHERE clause
            selectionArgs,  //The values for the WHERE clause
            null,  //group the rows
            null,  //filter by row groups
            null
        ) //The sort order
        val cursorCount = cursor.count
        cursor.close()
        db.close()
        return if (cursorCount > 0) {
            true
        } else false
    }

    companion object {
        fun authenticate(user: User) : User? {
            user.email
            user.password

            return user
        }

        // Database Version
        private const val DATABASE_VERSION = 1
        // Database Name
        private const val DATABASE_NAME = "UserManager.db"
        // User table name
        private const val TABLE_USER = "user"
        // User Table Columns names
        private const val COLUMN_USER_ID = "user_id"
        private const val COLUMN_USER_NAME = "user_name"
        private const val COLUMN_USER_EMAIL = "user_email"
        private const val COLUMN_USER_PASSWORD = "user_password"
    }
}
