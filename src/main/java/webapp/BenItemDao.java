package webapp;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import webapp.AppConfig;
import webapp.BenItem;

@Dao(config = AppConfig.class)
public interface BenItemDao {
	
	@Select
	List<BenItem> selectAll();
	
}