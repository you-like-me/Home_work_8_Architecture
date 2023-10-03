package View;

import Model.MyTableModel;

import java.util.List;

/**
 * Интерфейс представления для кафе.
 */
public interface CafeView {
    /**
     * Отображает доступные столики.
     * @param tables Список доступных столиков.
     */
    void showAvailableTables(List<MyTableModel> tables);

    /**
     * Отображает результат бронирования столика.
     * @param success     true, если бронирование успешно, иначе false.
     * @param tableNumber Номер столика.
     */
    void showReservationResult(boolean success, int tableNumber);

    /**
     * Отображает результат отмены бронирования столика.
     * @param success     true, если отмена успешна, иначе false.
     * @param tableNumber Номер столика.
     */
    void showCancellationResult(boolean success, int tableNumber);
}
