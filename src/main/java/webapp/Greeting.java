package webapp;

import java.util.List;
import com.google.gson.Gson;
import org.seasar.doma.jdbc.tx.TransactionManager;
import webapp.AppConfig;
import webapp.BenItemDao;
import webapp.BenItemDaoImpl;
import webapp.BenItem;

public class Greeting {

    public String All() {
        Gson gson = new Gson();
        TransactionManager tm = AppConfig.singleton().getTransactionManager();
        List allAcc = tm.required(() -> {
            BenItemDao dao = new BenItemDaoImpl();
            List<BenItem> list = dao.selectAll();
            return list;
        });
        String json = gson.toJson(allAcc);
        return json;   
    }
}