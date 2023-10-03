package Model;

/**
 * Модель данных стола.
 */
public class MyTableModel {
    private int number;
    private boolean isReserved;

    /**
     * Создает новую модель стола с заданным номером.
     * @param number Номер стола.
     */
    public MyTableModel(int number) {
        this.number = number;
        this.isReserved = false;
    }

    /**
     * Получить номер стола.
     * @return Номер стола.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Проверить, зарезервирован ли стол.
     * @return true, если стол зарезервирован, иначе false.
     */
    public boolean isReserved() {
        return isReserved;
    }

    /**
     * Зарезервировать стол.
     */
    public void reserve() {
        isReserved = true;
    }

    /**
     * Отменить резервирование стола.
     */
    public void cancelReservation() {
        isReserved = false;
    }
}
