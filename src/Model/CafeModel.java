package Model;


import java.util.ArrayList;
import java.util.List;

/**
 * Модель данных кафе.
 */
public class CafeModel {

    private String name;
    private List<MyTableModel> tables;

    /**
     * Создает новую модель кафе с заданным именем.
     * @param name Имя кафе.
     */
    public CafeModel(String name) {
        this.name = name;
        this.tables = new ArrayList<>();
    }

    /**
     * Получить список столов в кафе.
     * @return Список столов.
     */
    public List<MyTableModel> getTables() {
        return tables;
    }

    /**
     * Добавить стол в список столов кафе.
     * @param table Стол для добавления.
     */
    public void addTable(MyTableModel table) {
        tables.add(table);
    }
}