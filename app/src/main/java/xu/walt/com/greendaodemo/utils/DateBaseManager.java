package xu.walt.com.greendaodemo.utils;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.greendao.gen.DaoMaster;
import com.greendao.gen.DaoSession;
import com.greendao.gen.UserDao;

import java.lang.ref.WeakReference;
import java.util.List;

import xu.walt.com.greendaodemo.entity.User;

/**
 * Created by walt on 2019/4/15.
 */

public class DateBaseManager {
    private static DateBaseManager instance;
    private final String dbName ="pickup2.db";
//    private final DaoMaster.DevOpenHelper openHelper;
    private final MySQLiteOpenHelper mySQLiteOpenHelper;
    private WeakReference<Context> mContext;
    private final UserDao userDao;

    public DateBaseManager(Context context) {
        mContext = new WeakReference<Context>(context);
        //可以版本更新
        mySQLiteOpenHelper = new MySQLiteOpenHelper(mContext.get(), dbName, null);
        //加密
//        Database db = mySQLiteOpenHelper.getEncryptedWritableDb("xyd123456");
        SQLiteDatabase db = mySQLiteOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();
        userDao = daoSession.getUserDao();
    }

    public static synchronized DateBaseManager getInstance (Context context)  {
        if (  null==instance) {
            instance = new DateBaseManager(context);
        }
        return instance;
    }

    /**
     * 增加用户
     * @param user
     */
    public void insert(User user) {
        userDao.insertOrReplace(user);
    }

    /**
     * 按key删除数据
     * @param age
     */
    public void delete(int age) {
        List<User> list = userDao.queryBuilder()
                .where(UserDao.Properties.Age.eq(age)).list();
        try {
            userDao.deleteInTx(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查
     * @return
     */
    public String name ="";
    public String loadAll() {
        List<User> users = userDao.loadAll();
        for (int i = 0; i < users.size(); i++) {
             name = users.get(i).getName();
            name+=name;
        }
        return name;
    }
}
