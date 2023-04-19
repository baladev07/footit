package com.agsr.footit.feature_agsr.data.datasource;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.agsr.footit.feature_agsr.domain.model.User;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<User> __insertionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter<User> __deletionAdapterOfUser;

  public UserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `user` (`FirstName`,`LastName`,`DateFormatType`,`MetricType`,`CreatedTimeStamp`,`UpdatedTimeStamp`,`IsDeleted`,`UserId`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        if (value.getFirstName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getFirstName());
        }
        if (value.getLastName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getLastName());
        }
        stmt.bindLong(3, value.getDateFormatType());
        stmt.bindLong(4, value.getMetricType());
        if (value.getCreatedTimeStamp() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCreatedTimeStamp());
        }
        if (value.getUpdatedTimeStamp() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getUpdatedTimeStamp());
        }
        final int _tmp = value.getIsDeleted() ? 1 : 0;
        stmt.bindLong(7, _tmp);
        stmt.bindLong(8, value.getUserId());
      }
    };
    this.__deletionAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `user` WHERE `UserId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getUserId());
      }
    };
  }

  @Override
  public Object insertUser(final User user, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUser.insert(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteUser(final User user, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfUser.handle(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<User>> getUser() {
    final String _sql = "SELECT * FROM User";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"User"}, new Callable<List<User>>() {
      @Override
      public List<User> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfFirstName = CursorUtil.getColumnIndexOrThrow(_cursor, "FirstName");
          final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "LastName");
          final int _cursorIndexOfDateFormatType = CursorUtil.getColumnIndexOrThrow(_cursor, "DateFormatType");
          final int _cursorIndexOfMetricType = CursorUtil.getColumnIndexOrThrow(_cursor, "MetricType");
          final int _cursorIndexOfCreatedTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "CreatedTimeStamp");
          final int _cursorIndexOfUpdatedTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "UpdatedTimeStamp");
          final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "IsDeleted");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "UserId");
          final List<User> _result = new ArrayList<User>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final User _item;
            final String _tmpFirstName;
            if (_cursor.isNull(_cursorIndexOfFirstName)) {
              _tmpFirstName = null;
            } else {
              _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
            }
            final String _tmpLastName;
            if (_cursor.isNull(_cursorIndexOfLastName)) {
              _tmpLastName = null;
            } else {
              _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
            }
            final int _tmpDateFormatType;
            _tmpDateFormatType = _cursor.getInt(_cursorIndexOfDateFormatType);
            final int _tmpMetricType;
            _tmpMetricType = _cursor.getInt(_cursorIndexOfMetricType);
            final String _tmpCreatedTimeStamp;
            if (_cursor.isNull(_cursorIndexOfCreatedTimeStamp)) {
              _tmpCreatedTimeStamp = null;
            } else {
              _tmpCreatedTimeStamp = _cursor.getString(_cursorIndexOfCreatedTimeStamp);
            }
            final String _tmpUpdatedTimeStamp;
            if (_cursor.isNull(_cursorIndexOfUpdatedTimeStamp)) {
              _tmpUpdatedTimeStamp = null;
            } else {
              _tmpUpdatedTimeStamp = _cursor.getString(_cursorIndexOfUpdatedTimeStamp);
            }
            final boolean _tmpIsDeleted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsDeleted);
            _tmpIsDeleted = _tmp != 0;
            final int _tmpUserId;
            _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
            _item = new User(_tmpFirstName,_tmpLastName,_tmpDateFormatType,_tmpMetricType,_tmpCreatedTimeStamp,_tmpUpdatedTimeStamp,_tmpIsDeleted,_tmpUserId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getUserById(final int UserId, final Continuation<? super User> continuation) {
    final String _sql = "SELECT * FROM User WHERE UserId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, UserId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<User>() {
      @Override
      public User call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfFirstName = CursorUtil.getColumnIndexOrThrow(_cursor, "FirstName");
          final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "LastName");
          final int _cursorIndexOfDateFormatType = CursorUtil.getColumnIndexOrThrow(_cursor, "DateFormatType");
          final int _cursorIndexOfMetricType = CursorUtil.getColumnIndexOrThrow(_cursor, "MetricType");
          final int _cursorIndexOfCreatedTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "CreatedTimeStamp");
          final int _cursorIndexOfUpdatedTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "UpdatedTimeStamp");
          final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "IsDeleted");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "UserId");
          final User _result;
          if(_cursor.moveToFirst()) {
            final String _tmpFirstName;
            if (_cursor.isNull(_cursorIndexOfFirstName)) {
              _tmpFirstName = null;
            } else {
              _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
            }
            final String _tmpLastName;
            if (_cursor.isNull(_cursorIndexOfLastName)) {
              _tmpLastName = null;
            } else {
              _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
            }
            final int _tmpDateFormatType;
            _tmpDateFormatType = _cursor.getInt(_cursorIndexOfDateFormatType);
            final int _tmpMetricType;
            _tmpMetricType = _cursor.getInt(_cursorIndexOfMetricType);
            final String _tmpCreatedTimeStamp;
            if (_cursor.isNull(_cursorIndexOfCreatedTimeStamp)) {
              _tmpCreatedTimeStamp = null;
            } else {
              _tmpCreatedTimeStamp = _cursor.getString(_cursorIndexOfCreatedTimeStamp);
            }
            final String _tmpUpdatedTimeStamp;
            if (_cursor.isNull(_cursorIndexOfUpdatedTimeStamp)) {
              _tmpUpdatedTimeStamp = null;
            } else {
              _tmpUpdatedTimeStamp = _cursor.getString(_cursorIndexOfUpdatedTimeStamp);
            }
            final boolean _tmpIsDeleted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsDeleted);
            _tmpIsDeleted = _tmp != 0;
            final int _tmpUserId;
            _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
            _result = new User(_tmpFirstName,_tmpLastName,_tmpDateFormatType,_tmpMetricType,_tmpCreatedTimeStamp,_tmpUpdatedTimeStamp,_tmpIsDeleted,_tmpUserId);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
