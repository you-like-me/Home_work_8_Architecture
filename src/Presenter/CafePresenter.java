package Presenter;

import Model.CafeModel;
import Model.MyTableModel;
import View.CafeView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Презентер для кафе.
 */
public class CafePresenter {

    private CafeModel cafeModel;
    private CafeView cafeView;
    private Scanner scanner;

    /**
     * Создает новый презентер с указанной моделью и представлением.
     *
     * @param cafeModel Модель кафе.
     * @param cafeView  Представление кафе.
     */
    public CafePresenter(CafeModel cafeModel, CafeView cafeView) {
        this.cafeModel = cafeModel;
        this.cafeView = cafeView;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Запускает приложение.
     */
    public void start() {
        int choice;

        do {
            System.out.println("Меню:");
            System.out.println("1. Просмотреть доступные столики");
            System.out.println("2. Забронировать столик");
            System.out.println("3. Отменить бронирование столика");
            System.out.println("4. Выйти из приложения");
            System.out.print("Выберите действие: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayAvailableTables();
                    break;
                case 2:
                    reserveTable();
                    break;
                case 3:
                    cancelReservation();
                    break;
                case 4:
                    System.out.println("Выход из приложения.");
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
                    break;
            }
        } while (choice != 4);
    }

    private void displayAvailableTables() {
        List<MyTableModel> availableTables = cafeModel.getTables();
        List<MyTableModel> unreservedTables = new ArrayList<>();

        for (MyTableModel table : availableTables) {
            if (!table.isReserved()) {
                unreservedTables.add(table);
            }
        }
        cafeView.showAvailableTables(unreservedTables);
    }

    private void reserveTable() {
        List<MyTableModel> availableTables = cafeModel.getTables();
        cafeView.showAvailableTables(availableTables);
        System.out.print("Введите номер столика, который вы хотите забронировать: ");
        int tableNumber = scanner.nextInt();

        for (MyTableModel table : availableTables) {
            if (table.getNumber() == tableNumber && !table.isReserved()) {
                table.reserve();
                cafeView.showReservationResult(true, tableNumber);
                return;
            }
        }

        cafeView.showReservationResult(false, tableNumber);
    }

    private void cancelReservation() {
        List<MyTableModel> reservedTables = cafeModel.getTables();
        cafeView.showAvailableTables(reservedTables);
        System.out.print("Введите номер столика, для которого хотите отменить бронирование: ");
        int tableNumber = scanner.nextInt();

        for (MyTableModel table : reservedTables) {
            if (table.getNumber() == tableNumber && table.isReserved()) {
                table.cancelReservation();
                cafeView.showCancellationResult(true, tableNumber);
                return;
            }
        }
        cafeView.showCancellationResult(false, tableNumber);
    }
}
