package com.agsr.footit.feature_agsr.data.datasource;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.agsr.footit.feature_agsr.domain.model.Steps;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
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
public final class StepsDao_Impl implements StepsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Steps> __insertionAdapterOfSteps;

  private final EntityDeletionOrUpdateAdapter<Steps> __deletionAdapterOfSteps;

  private final EntityDeletionOrUpdateAdapter<Steps> __updateAdapterOfSteps;

  public StepsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSteps = new EntityInsertionAdapter<Steps>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Steps` (`StepCount`,`ActivityDate`,`CreatedTimeStamp`,`UpdatedTimeStamp`,`IsDeleted`,`GoalId`,`GoalName`,`GoalStep`,`StepId`) VALUES (?,?,?,?,?,?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Steps value) {
        stmt.bindLong(1, value.getStepCount());
        if (value.getActivityDate() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getActivityDate());
        }
        if (value.getCreatedTimeStamp() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCreatedTimeStamp());
        }
        if (value.getUpdatedTimeStamp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUpdatedTimeStamp());
        }
        final int _tmp = value.getIsDeleted() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        if (value.getGoalId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getGoalId());
        }
        if (value.getGoalName() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getGoalName());
        }
        stmt.bindLong(8, value.getGoalStep());
        stmt.bindLong(9, value.getStepId());
      }
    };
    this.__deletionAdapterOfSteps = new EntityDeletionOrUpdateAdapter<Steps>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Steps` WHERE `StepId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Steps value) {
        stmt.bindLong(1, value.getStepId());
      }
    };
    this.__updateAdapterOfSteps = new EntityDeletionOrUpdateAdapter<Steps>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Steps` SET `StepCount` = ?,`ActivityDate` = ?,`CreatedTimeStamp` = ?,`UpdatedTimeStamp` = ?,`IsDeleted` = ?,`GoalId` = ?,`GoalName` = ?,`GoalStep` = ?,`StepId` = ? WHERE `StepId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Steps value) {
        stmt.bindLong(1, value.getStepCount());
        if (value.getActivityDate() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getActivityDate());
        }
        if (value.getCreatedTimeStamp() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCreatedTimeStamp());
        }
        if (value.getUpdatedTimeStamp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUpdatedTimeStamp());
        }
        final int _tmp = value.getIsDeleted() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        if (value.getGoalId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getGoalId());
        }
        if (value.getGoalName() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getGoalName());
        }
        stmt.bindLong(8, value.getGoalStep());
        stmt.bindLong(9, value.getStepId());
        stmt.bindLong(10, value.getStepId());
      }
    };
  }

  @Override
  public Object insertSteps(final Steps steps, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfSteps.insert(steps);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteSteps(final Steps steps, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfSteps.handle(steps);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateSteps(final Steps steps, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfSteps.handle(steps);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public List<Steps> getSteps() {
    final String _sql = "SELECT * FROM Steps WHERE IsDeleted = false ORDER BY ActivityDate Desc";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfStepCount = CursorUtil.getColumnIndexOrThrow(_cursor, "StepCount");
      final int _cursorIndexOfActivityDate = CursorUtil.getColumnIndexOrThrow(_cursor, "ActivityDate");
      final int _cursorIndexOfCreatedTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "CreatedTimeStamp");
      final int _cursorIndexOfUpdatedTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "UpdatedTimeStamp");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "IsDeleted");
      final int _cursorIndexOfGoalId = CursorUtil.getColumnIndexOrThrow(_cursor, "GoalId");
      final int _cursorIndexOfGoalName = CursorUtil.getColumnIndexOrThrow(_cursor, "GoalName");
      final int _cursorIndexOfGoalStep = CursorUtil.getColumnIndexOrThrow(_cursor, "GoalStep");
      final int _cursorIndexOfStepId = CursorUtil.getColumnIndexOrThrow(_cursor, "StepId");
      final List<Steps> _result = new ArrayList<Steps>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Steps _item;
        final int _tmpStepCount;
        _tmpStepCount = _cursor.getInt(_cursorIndexOfStepCount);
        final String _tmpActivityDate;
        if (_cursor.isNull(_cursorIndexOfActivityDate)) {
          _tmpActivityDate = null;
        } else {
          _tmpActivityDate = _cursor.getString(_cursorIndexOfActivityDate);
        }
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
        final Integer _tmpGoalId;
        if (_cursor.isNull(_cursorIndexOfGoalId)) {
          _tmpGoalId = null;
        } else {
          _tmpGoalId = _cursor.getInt(_cursorIndexOfGoalId);
        }
        final String _tmpGoalName;
        if (_cursor.isNull(_cursorIndexOfGoalName)) {
          _tmpGoalName = null;
        } else {
          _tmpGoalName = _cursor.getString(_cursorIndexOfGoalName);
        }
        final int _tmpGoalStep;
        _tmpGoalStep = _cursor.getInt(_cursorIndexOfGoalStep);
        final int _tmpStepId;
        _tmpStepId = _cursor.getInt(_cursorIndexOfStepId);
        _item = new Steps(_tmpStepCount,_tmpActivityDate,_tmpCreatedTimeStamp,_tmpUpdatedTimeStamp,_tmpIsDeleted,_tmpGoalId,_tmpGoalName,_tmpGoalStep,_tmpStepId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Steps getStepsByDate(final String ActivityDate) {
    final String _sql = "SELECT * FROM Steps WHERE ActivityDate = ? AND IsDeleted = false";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (ActivityDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ActivityDate);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfStepCount = CursorUtil.getColumnIndexOrThrow(_cursor, "StepCount");
      final int _cursorIndexOfActivityDate = CursorUtil.getColumnIndexOrThrow(_cursor, "ActivityDate");
      final int _cursorIndexOfCreatedTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "CreatedTimeStamp");
      final int _cursorIndexOfUpdatedTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "UpdatedTimeStamp");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "IsDeleted");
      final int _cursorIndexOfGoalId = CursorUtil.getColumnIndexOrThrow(_cursor, "GoalId");
      final int _cursorIndexOfGoalName = CursorUtil.getColumnIndexOrThrow(_cursor, "GoalName");
      final int _cursorIndexOfGoalStep = CursorUtil.getColumnIndexOrThrow(_cursor, "GoalStep");
      final int _cursorIndexOfStepId = CursorUtil.getColumnIndexOrThrow(_cursor, "StepId");
      final Steps _result;
      if(_cursor.moveToFirst()) {
        final int _tmpStepCount;
        _tmpStepCount = _cursor.getInt(_cursorIndexOfStepCount);
        final String _tmpActivityDate;
        if (_cursor.isNull(_cursorIndexOfActivityDate)) {
          _tmpActivityDate = null;
        } else {
          _tmpActivityDate = _cursor.getString(_cursorIndexOfActivityDate);
        }
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
        final Integer _tmpGoalId;
        if (_cursor.isNull(_cursorIndexOfGoalId)) {
          _tmpGoalId = null;
        } else {
          _tmpGoalId = _cursor.getInt(_cursorIndexOfGoalId);
        }
        final String _tmpGoalName;
        if (_cursor.isNull(_cursorIndexOfGoalName)) {
          _tmpGoalName = null;
        } else {
          _tmpGoalName = _cursor.getString(_cursorIndexOfGoalName);
        }
        final int _tmpGoalStep;
        _tmpGoalStep = _cursor.getInt(_cursorIndexOfGoalStep);
        final int _tmpStepId;
        _tmpStepId = _cursor.getInt(_cursorIndexOfStepId);
        _result = new Steps(_tmpStepCount,_tmpActivityDate,_tmpCreatedTimeStamp,_tmpUpdatedTimeStamp,_tmpIsDeleted,_tmpGoalId,_tmpGoalName,_tmpGoalStep,_tmpStepId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
