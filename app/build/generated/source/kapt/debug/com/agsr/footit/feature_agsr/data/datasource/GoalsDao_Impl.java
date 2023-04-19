package com.agsr.footit.feature_agsr.data.datasource;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.agsr.footit.feature_agsr.domain.model.Goal;
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

@SuppressWarnings({"unchecked", "deprecation"})
public final class GoalsDao_Impl implements GoalsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Goal> __insertionAdapterOfGoal;

  private final EntityDeletionOrUpdateAdapter<Goal> __updateAdapterOfGoal;

  private final SharedSQLiteStatement __preparedStmtOfDeleteGoal;

  public GoalsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGoal = new EntityInsertionAdapter<Goal>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Goal` (`GoalName`,`StepCount`,`IsGoalActive`,`CreatedTimeStamp`,`UpdatedTimeStamp`,`IsDeleted`,`GoalId`) VALUES (?,?,?,?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Goal value) {
        if (value.getGoalName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getGoalName());
        }
        if (value.getStepCount() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getStepCount());
        }
        final int _tmp = value.getIsGoalActive() ? 1 : 0;
        stmt.bindLong(3, _tmp);
        if (value.getCreatedTimeStamp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCreatedTimeStamp());
        }
        if (value.getUpdatedTimeStamp() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUpdatedTimeStamp());
        }
        final int _tmp_1 = value.getIsDeleted() ? 1 : 0;
        stmt.bindLong(6, _tmp_1);
        stmt.bindLong(7, value.getGoalId());
      }
    };
    this.__updateAdapterOfGoal = new EntityDeletionOrUpdateAdapter<Goal>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Goal` SET `GoalName` = ?,`StepCount` = ?,`IsGoalActive` = ?,`CreatedTimeStamp` = ?,`UpdatedTimeStamp` = ?,`IsDeleted` = ?,`GoalId` = ? WHERE `GoalId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Goal value) {
        if (value.getGoalName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getGoalName());
        }
        if (value.getStepCount() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getStepCount());
        }
        final int _tmp = value.getIsGoalActive() ? 1 : 0;
        stmt.bindLong(3, _tmp);
        if (value.getCreatedTimeStamp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCreatedTimeStamp());
        }
        if (value.getUpdatedTimeStamp() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUpdatedTimeStamp());
        }
        final int _tmp_1 = value.getIsDeleted() ? 1 : 0;
        stmt.bindLong(6, _tmp_1);
        stmt.bindLong(7, value.getGoalId());
        stmt.bindLong(8, value.getGoalId());
      }
    };
    this.__preparedStmtOfDeleteGoal = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Goal WHERE GoalId = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertGoal(final Goal goal, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfGoal.insert(goal);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateGoal(final Goal goal, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfGoal.handle(goal);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteGoal(final int id, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteGoal.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteGoal.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public List<Goal> getGoals() {
    final String _sql = "SELECT * FROM Goal WHERE IsDeleted = false";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfGoalName = CursorUtil.getColumnIndexOrThrow(_cursor, "GoalName");
      final int _cursorIndexOfStepCount = CursorUtil.getColumnIndexOrThrow(_cursor, "StepCount");
      final int _cursorIndexOfIsGoalActive = CursorUtil.getColumnIndexOrThrow(_cursor, "IsGoalActive");
      final int _cursorIndexOfCreatedTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "CreatedTimeStamp");
      final int _cursorIndexOfUpdatedTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "UpdatedTimeStamp");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "IsDeleted");
      final int _cursorIndexOfGoalId = CursorUtil.getColumnIndexOrThrow(_cursor, "GoalId");
      final List<Goal> _result = new ArrayList<Goal>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Goal _item;
        final String _tmpGoalName;
        if (_cursor.isNull(_cursorIndexOfGoalName)) {
          _tmpGoalName = null;
        } else {
          _tmpGoalName = _cursor.getString(_cursorIndexOfGoalName);
        }
        final String _tmpStepCount;
        if (_cursor.isNull(_cursorIndexOfStepCount)) {
          _tmpStepCount = null;
        } else {
          _tmpStepCount = _cursor.getString(_cursorIndexOfStepCount);
        }
        final boolean _tmpIsGoalActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsGoalActive);
        _tmpIsGoalActive = _tmp != 0;
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
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsDeleted);
        _tmpIsDeleted = _tmp_1 != 0;
        final int _tmpGoalId;
        _tmpGoalId = _cursor.getInt(_cursorIndexOfGoalId);
        _item = new Goal(_tmpGoalName,_tmpStepCount,_tmpIsGoalActive,_tmpCreatedTimeStamp,_tmpUpdatedTimeStamp,_tmpIsDeleted,_tmpGoalId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Object getGoalById(final int GoalId, final Continuation<? super Goal> continuation) {
    final String _sql = "SELECT * FROM Goal WHERE GoalId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, GoalId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Goal>() {
      @Override
      public Goal call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfGoalName = CursorUtil.getColumnIndexOrThrow(_cursor, "GoalName");
          final int _cursorIndexOfStepCount = CursorUtil.getColumnIndexOrThrow(_cursor, "StepCount");
          final int _cursorIndexOfIsGoalActive = CursorUtil.getColumnIndexOrThrow(_cursor, "IsGoalActive");
          final int _cursorIndexOfCreatedTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "CreatedTimeStamp");
          final int _cursorIndexOfUpdatedTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "UpdatedTimeStamp");
          final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "IsDeleted");
          final int _cursorIndexOfGoalId = CursorUtil.getColumnIndexOrThrow(_cursor, "GoalId");
          final Goal _result;
          if(_cursor.moveToFirst()) {
            final String _tmpGoalName;
            if (_cursor.isNull(_cursorIndexOfGoalName)) {
              _tmpGoalName = null;
            } else {
              _tmpGoalName = _cursor.getString(_cursorIndexOfGoalName);
            }
            final String _tmpStepCount;
            if (_cursor.isNull(_cursorIndexOfStepCount)) {
              _tmpStepCount = null;
            } else {
              _tmpStepCount = _cursor.getString(_cursorIndexOfStepCount);
            }
            final boolean _tmpIsGoalActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsGoalActive);
            _tmpIsGoalActive = _tmp != 0;
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
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsDeleted);
            _tmpIsDeleted = _tmp_1 != 0;
            final int _tmpGoalId;
            _tmpGoalId = _cursor.getInt(_cursorIndexOfGoalId);
            _result = new Goal(_tmpGoalName,_tmpStepCount,_tmpIsGoalActive,_tmpCreatedTimeStamp,_tmpUpdatedTimeStamp,_tmpIsDeleted,_tmpGoalId);
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
