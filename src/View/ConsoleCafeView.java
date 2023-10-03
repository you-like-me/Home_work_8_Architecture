package View;

import Model.MyTableModel;
import Presenter.CafePresenter;

import java.util.List;

/**
 * Консольное представление кафе.
 */
public class ConsoleCafeView implements View.CafeView {

    private CafePresenter cafePresenter;

    /**
     * Устанавливает презентер для представления.
     *
     * @param cafePresenter Презентер.
     */
    public void setPresenter(CafePresenter cafePresenter) {
        this.cafePresenter = cafePresenter;
    }

    @Override
    public void showAvailableTables(List<MyTableModel> tables) {
        System.out.println("Доступные столики:");
        for (MyTableModel table : tables) {
            System.out.println("Столик #" + table.getNumber());
        }
    }

    @Override
    public void showReservationResult(boolean success, int tableNumber) {
        if (success) {
            System.out.println("Столик #" + tableNumber + " успешно забронирован.");
        }
        else {
            System.out.println("Извините, выбранный столик уже забронирован или не существует.");
        }
    }

    @Override
    public void showCancellationResult(boolean success, int tableNumber) {
        if (success) {
            System.out.println("Бронирование для столика #" + tableNumber + " успешно отменено.");
        }
        else {
            System.out.println("Извините, выбранное бронирование не найдено.");
        }
    }
}
