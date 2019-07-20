package Pwater.Model;

import java.util.List;
import org.seasar.doma.jdbc.tx.TransactionManager;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;

import Pwater.Config.AppConfig;
import Pwater.Dao.AccountDao;
import Pwater.Dao.AccountDaoImpl;

@Entity
public class Account {

    @Column(name = "id")
    private Integer id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "item_id")
    private Integer itemId;
    
    @Column(name = "item_name")
    private String itemName;
    
    @Column(name = "item_price")
    private Integer itemPrice;
    
    @Column(name = "item_count")
    private Integer itemCount;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }   
    public Integer getItemId() {
        return itemId;
    }
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public Integer getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(Integer itemPrice) {
        this.itemPrice = itemPrice;
    }
    public Integer getItemCount() {
        return itemCount;
    }
    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }
    
    public String toString() {
        String res = "";
        
        res += this.getId() + " ";
        res += this.getName() + " ";
        res += this.getItemId() + " ";
        res += this.getItemName() + " ";
        res += this.getItemPrice() + " ";
        res += this.getItemCount() + " ";
        
        return res;
    }

    public List GetAll(){
		TransactionManager tm = AppConfig.singleton().getTransactionManager();
        List allAcc = tm.required(() -> {
            AccountDao dao = new AccountDaoImpl();
            List list = dao.selectAll();
            return list;
        });
    	// Map<String, String> account = new HashMap<String, String>();
    	// account.put("master","admin");
    	// account.put("hana","mod");
    	// account.put("ben","mod");
    	// account.put("binh","user");
    	// account.put("tram","user");
    	// return account;
    	return allAcc;
    }
}

    