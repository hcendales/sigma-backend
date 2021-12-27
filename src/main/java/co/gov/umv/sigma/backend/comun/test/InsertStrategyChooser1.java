package co.gov.umv.sigma.backend.comun.test;

import pl.jsolve.templ4docx.cleaner.ParagraphCleaner;
import pl.jsolve.templ4docx.cleaner.TableRowCleaner;
import pl.jsolve.templ4docx.insert.Insert;
import pl.jsolve.templ4docx.strategy.BulletListInsertStrategy;
import pl.jsolve.templ4docx.strategy.ImageInsertStrategy;
import pl.jsolve.templ4docx.strategy.TableInsertStrategy;
import pl.jsolve.templ4docx.strategy.TextInsertStrategy;
import pl.jsolve.templ4docx.util.Key;
import pl.jsolve.templ4docx.variable.Variable;
import pl.jsolve.templ4docx.variable.Variables;

public class InsertStrategyChooser1 {

    private TextInsertStrategy1 textInsertStrategy;
    private ImageInsertStrategy imageInsertStrategy;
    private TableInsertStrategy1 tableInsertStrategy;
    private BulletListInsertStrategy1 bulletListInsertStrategy;
    private Variables variables;

    public InsertStrategyChooser1(Variables variables, TableRowCleaner tableRowCleaner, ParagraphCleaner paragraphCleaner) {
        this.textInsertStrategy = new TextInsertStrategy1();
        this.imageInsertStrategy = new ImageInsertStrategy();
        this.tableInsertStrategy = new TableInsertStrategy1(variables, this, tableRowCleaner);
        this.bulletListInsertStrategy = new BulletListInsertStrategy1(this, paragraphCleaner);
        this.variables = variables;
    }

    public void replace(Insert insert, Variable variable) {
        switch (insert.getKey().getVariableType()) {
        case TEXT:
            textInsertStrategy.insert(insert, variable);
            break;
        case IMAGE:
            imageInsertStrategy.insert(insert, variable);
            break;
        case TABLE:
            tableInsertStrategy.insert(insert, variable);
            break;
        case BULLET_LIST:
            bulletListInsertStrategy.insert(insert, variable);
            break;
        }
    }

    public void replace(Insert insert) {
        replace(insert, variables.getVariable(insert.getKey()));
    }

    public void cleanUp() {
        tableInsertStrategy.cleanRows();
        bulletListInsertStrategy.cleanParagraphs();
    }
}
