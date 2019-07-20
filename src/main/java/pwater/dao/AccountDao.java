package Pwater.Dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import Pwater.Config.AppConfig;
import Pwater.Model.Account;

@Dao(config = AppConfig.class)
public interface AccountDao {
	
	@Select
	List<Account> selectAll();
	
}