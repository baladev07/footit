package com.agsr.footit.feature_agsr.data.datasource;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class FootItDatabase_Impl extends FootItDatabase {
  private volatile UserDao _userDao;

  private volatile StepsDao _stepsDao;

  private volatile GoalsDao _goalsDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(4) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `user` (`FirstName` TEXT NOT NULL, `LastName` TEXT NOT NULL, `DateFormatType` INTEGER NOT NULL, `MetricType` INTEGER NOT NULL, `CreatedTimeStamp` TEXT NOT NULL DEFAULT '5', `UpdatedTimeStamp` TEXT NOT NULL DEFAULT '5', `IsDeleted` INTEGER NOT NULL DEFAULT false, `UserId` INTEGER NOT NULL, PRIMARY KEY(`UserId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Steps` (`StepCount` INTEGER NOT NULL, `ActivityDate` TEXT NOT NULL, `CreatedTimeStamp` TEXT NOT NULL DEFAULT '5', `UpdatedTimeStamp` TEXT NOT NULL DEFAULT '5', `IsDeleted` INTEGER NOT NULL DEFAULT false, `GoalId` INTEGER, `GoalName` TEXT NOT NULL, `GoalStep` INTEGER NOT NULL, `StepId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Goal` (`GoalName` TEXT NOT NULL, `StepCount` TEXT NOT NULL, `IsGoalActive` INTEGER NOT NULL, `CreatedTimeStamp` TEXT NOT NULL DEFAULT '5', `UpdatedTimeStamp` TEXT NOT NULL DEFAULT '5', `IsDeleted` INTEGER NOT NULL DEFAULT false, `GoalId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '48eeb9bce94aa7708050b936a7fc99e1')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `user`");
        _db.execSQL("DROP TABLE IF EXISTS `Steps`");
        _db.execSQL("DROP TABLE IF EXISTS `Goal`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsUser = new HashMap<String, TableInfo.Column>(8);
        _columnsUser.put("FirstName", new TableInfo.Column("FirstName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("LastName", new TableInfo.Column("LastName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("DateFormatType", new TableInfo.Column("DateFormatType", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("MetricType", new TableInfo.Column("MetricType", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("CreatedTimeStamp", new TableInfo.Column("CreatedTimeStamp", "TEXT", true, 0, "'5'", TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("UpdatedTimeStamp", new TableInfo.Column("UpdatedTimeStamp", "TEXT", true, 0, "'5'", TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("IsDeleted", new TableInfo.Column("IsDeleted", "INTEGER", true, 0, "false", TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("UserId", new TableInfo.Column("UserId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUser = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUser = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUser = new TableInfo("user", _columnsUser, _foreignKeysUser, _indicesUser);
        final TableInfo _existingUser = TableInfo.read(_db, "user");
        if (! _infoUser.equals(_existingUser)) {
          return new RoomOpenHelper.ValidationResult(false, "user(com.agsr.footit.feature_agsr.domain.model.User).\n"
                  + " Expected:\n" + _infoUser + "\n"
                  + " Found:\n" + _existingUser);
        }
        final HashMap<String, TableInfo.Column> _columnsSteps = new HashMap<String, TableInfo.Column>(9);
        _columnsSteps.put("StepCount", new TableInfo.Column("StepCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSteps.put("ActivityDate", new TableInfo.Column("ActivityDate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSteps.put("CreatedTimeStamp", new TableInfo.Column("CreatedTimeStamp", "TEXT", true, 0, "'5'", TableInfo.CREATED_FROM_ENTITY));
        _columnsSteps.put("UpdatedTimeStamp", new TableInfo.Column("UpdatedTimeStamp", "TEXT", true, 0, "'5'", TableInfo.CREATED_FROM_ENTITY));
        _columnsSteps.put("IsDeleted", new TableInfo.Column("IsDeleted", "INTEGER", true, 0, "false", TableInfo.CREATED_FROM_ENTITY));
        _columnsSteps.put("GoalId", new TableInfo.Column("GoalId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSteps.put("GoalName", new TableInfo.Column("GoalName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSteps.put("GoalStep", new TableInfo.Column("GoalStep", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSteps.put("StepId", new TableInfo.Column("StepId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSteps = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSteps = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSteps = new TableInfo("Steps", _columnsSteps, _foreignKeysSteps, _indicesSteps);
        final TableInfo _existingSteps = TableInfo.read(_db, "Steps");
        if (! _infoSteps.equals(_existingSteps)) {
          return new RoomOpenHelper.ValidationResult(false, "Steps(com.agsr.footit.feature_agsr.domain.model.Steps).\n"
                  + " Expected:\n" + _infoSteps + "\n"
                  + " Found:\n" + _existingSteps);
        }
        final HashMap<String, TableInfo.Column> _columnsGoal = new HashMap<String, TableInfo.Column>(7);
        _columnsGoal.put("GoalName", new TableInfo.Column("GoalName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGoal.put("StepCount", new TableInfo.Column("StepCount", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGoal.put("IsGoalActive", new TableInfo.Column("IsGoalActive", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGoal.put("CreatedTimeStamp", new TableInfo.Column("CreatedTimeStamp", "TEXT", true, 0, "'5'", TableInfo.CREATED_FROM_ENTITY));
        _columnsGoal.put("UpdatedTimeStamp", new TableInfo.Column("UpdatedTimeStamp", "TEXT", true, 0, "'5'", TableInfo.CREATED_FROM_ENTITY));
        _columnsGoal.put("IsDeleted", new TableInfo.Column("IsDeleted", "INTEGER", true, 0, "false", TableInfo.CREATED_FROM_ENTITY));
        _columnsGoal.put("GoalId", new TableInfo.Column("GoalId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGoal = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGoal = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGoal = new TableInfo("Goal", _columnsGoal, _foreignKeysGoal, _indicesGoal);
        final TableInfo _existingGoal = TableInfo.read(_db, "Goal");
        if (! _infoGoal.equals(_existingGoal)) {
          return new RoomOpenHelper.ValidationResult(false, "Goal(com.agsr.footit.feature_agsr.domain.model.Goal).\n"
                  + " Expected:\n" + _infoGoal + "\n"
                  + " Found:\n" + _existingGoal);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "48eeb9bce94aa7708050b936a7fc99e1", "70f1eae783a558dcec4b6fa132b0ea6b");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "user","Steps","Goal");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `user`");
      _db.execSQL("DELETE FROM `Steps`");
      _db.execSQL("DELETE FROM `Goal`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(StepsDao.class, StepsDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(GoalsDao.class, GoalsDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public StepsDao stepsDao() {
    if (_stepsDao != null) {
      return _stepsDao;
    } else {
      synchronized(this) {
        if(_stepsDao == null) {
          _stepsDao = new StepsDao_Impl(this);
        }
        return _stepsDao;
      }
    }
  }

  @Override
  public GoalsDao goalsDao() {
    if (_goalsDao != null) {
      return _goalsDao;
    } else {
      synchronized(this) {
        if(_goalsDao == null) {
          _goalsDao = new GoalsDao_Impl(this);
        }
        return _goalsDao;
      }
    }
  }
}
