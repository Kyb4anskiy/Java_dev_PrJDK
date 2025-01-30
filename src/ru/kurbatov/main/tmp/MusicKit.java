package ru.kurbatov.main.tmp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class MusicKit {
    private static HashMap<String, HashSet<String>> local = new HashMap<>();

    public static void startMusicKit() {
        var console = new Scanner(System.in);
        boolean stopCall = false;

        showTitle();

        while (!stopCall) {
            System.out.print("\n>>> ");
            String call = console.nextLine();

            for (char i : call.toCharArray()) {
                if (Character.isLetter(i)) {
                    throw new IllegalArgumentException("Ошибка исполнения");
                }
            }

            switch (call) {
                case "1": {
                    showAllAlbums();
                    System.out.println("\n<<< Назад");
                    break;
                }

                case "2": {
                    var localConsole = new Scanner(System.in);

                    System.out.println(
                            "Введите название альбома --- "
                    );

                    String localAlbumName = localConsole.nextLine();

                    System.out.println(
                            "Введите количество треков --- "
                    );

                    int localTrackCount = localConsole.nextInt();
                    addNewAlbum(localAlbumName, localTrackCount);
                    System.out.println("\n<<< Назад");
                    break;
                }

                case "3": {
                    var localConsole = new Scanner(System.in);
                    System.out.println("Введите название альбома: ");
                    String localAlbumNames = localConsole.nextLine();

                    for (char i : localAlbumNames.toCharArray()) {
                        if (Character.isDigit(i)) {
                            throw new IllegalArgumentException("Ошибка исполнения");
                        }
                    }

                    if (local.containsKey(localAlbumNames)) {
                        showSongList(localAlbumNames);
                        System.out.println("\n<<< Назад");
                    } else {
                        System.out.println("\nАльбом не найден.");
                        System.out.println("\n<<< Назад");
                    }
                    break;
                }

                case "4": {
                    stopCall = true;
                    break;
                }

                case "<<<": {
                    showTitle();
                    break;
                }
            }
        }
    }

    private static void addNewAlbum(String albumName, int songsCount) {
        if (local.containsKey(albumName)) {
            System.out.println("Данный альбом уже существует!");
        } else {
            HashSet<String> newSongs = new HashSet<>();
            Scanner console = new Scanner(System.in);
            for (int i = 0; i < songsCount; i++) {
                System.out.println(String.format("Введите название трека #%d: ", i + 1));
                String song = console.nextLine();
                if (song.isBlank()) {
                    System.out.println("Ошибка при добавлении трека.");
                    break;
                } else {
                    newSongs.add(song);
                }
            }
            local.put(albumName, newSongs);
            System.out.println(String.format("Альбом \"%s\" успешно добавлен!", albumName));
        }
    }

    private static void showSongList(String albumName) {
        if (local.containsKey(albumName)) {
            System.out.println(String.format("\nСписок треков из альбома \"%s\":", albumName));
            int count = 1;
            for (String i : local.get(albumName)) {
                System.out.println(String.format("%d. %s", count, i));
                count++;
            }
        } else {
            System.out.println("Данного альбома нет в списке!");
        }
    }

    private static void showAllAlbums() {
        if (local.size() == 0) {
            System.out.println("Коробка с альбомами с альбомами пуста!");
        } else {
            int count2 = 1;
            System.out.println(String.format("\nВсе альбомы: "));
            Iterator<String> iterator = local.keySet().iterator();
            while (iterator.hasNext()) {
                String album = iterator.next();
                System.out.println(String.format(
                        "%d. %s (Количество треков: %d)", count2, album, local.get(album).size())
                );
            }
        }
    }

    private static void showTitle() {
        System.out.println(
                "\n1. Посмотреть список альбомов\n" +
                        "2. Добавить новый альбом\n" +
                        "3. Открыть альбом\n" +
                        "4. Выйти"
        );
    }
}