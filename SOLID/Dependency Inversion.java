interface Database
{
    void connect();
}

class OracleDb implements Database{
    @Override
    public void connect() {
        System.out.println("From Oracle Db0");
    }
}

class MySqlDb implements Database
{

    @Override
    public void connect() {
        System.out.println("From mysql db");
    }
    
}

class DbService{
    Database dbinterface;

    public DbService(Database dbinterface) {
        this.dbinterface = dbinterface;
    }

    void DbServiceConnect()
    {
        dbinterface.connect();
        System.out.println("From db service ");
    }

    
}

class DI
{
    public static void main(String[] args) {
        MySqlDb db1 = new MySqlDb();
        // DbService db = new DbService(db1);
        DbService db = new DbService(new OracleDb());
        db.DbServiceConnect();
    }
}

// not that too much good

// high level module should not depend on low level module 

// so take interface

// class DbName {
//     void DbNameMethod() {
//         System.err.println("From db sql , oracle, plsql");
//     }
// }

// class DbConnection {

//     DbName db;

//     DbConnection(DbName db)
//     {
//         this.db = db;
//     }

//     void DbConnectionMethod()
//     {
//         db.DbNameMethod();
//         System.err.println("Connection established");
//     }
// }

// public class DI {
//     public static void main(String[] args) {
//         DbName sql = new DbName();

//         DbName oracle = new DbName();

//         // DbConnection dbconn = new DbConnection(sql);
//         DbConnection dbconn = new DbConnection(oracle);
//         dbconn.DbConnectionMethod();
//     }
// }
