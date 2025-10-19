package metier;

import dao.IDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("metier")
public class MetierImpl implements IMetier {
    @Autowired
    private IDao dao;                 // pas de @Qualifier ici

    @Override
    public double calcul() { return dao.getValue() * 2; }

    @PostConstruct
    private void init() {
        // ligne optionnelle et non intrusive pour voir la classe injectée
        System.out.println("[TRACE] DAO injecté = " + dao.getClass().getSimpleName());
    }
}
