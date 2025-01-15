package ru.maksirep.softaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Report {

    private static final String NO_CHANGE = "0";

    public void generateReport(Map<String, String> prevPages, Map<String, String> newPages) {
        if (prevPages == null || newPages == null) {
            sendMessage(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
            return;
        }
        List<String> newPagesUrls = findNewPagesUrls(prevPages, newPages);
        List<String> deletedPagesUrls = findDeletedPagesUrls(prevPages, newPages);
        List<String> changedPagesUrls = findChangedPagesUrls(prevPages, newPages);
        sendMessage(newPagesUrls, deletedPagesUrls, changedPagesUrls);
    }

    private List<String> findDeletedPagesUrls(Map<String, String> prevPages, Map<String, String> newPages) {
        List<String> deletedPagesUrlsSet = new ArrayList<>(prevPages.keySet());
        deletedPagesUrlsSet.removeAll(newPages.keySet());
        return deletedPagesUrlsSet;
    }

    private List<String> findNewPagesUrls(Map<String, String> prevPages, Map<String, String> newPages) {
        List<String> newPagesUrlsSet = new ArrayList<>(newPages.keySet());
        newPagesUrlsSet.removeAll(prevPages.keySet());
        return newPagesUrlsSet;
    }

    private List<String> findChangedPagesUrls(Map<String, String> prevPages, Map<String, String> newPages) {
        List<String> joinPagesUrls = new ArrayList<>(prevPages.keySet());
        joinPagesUrls.retainAll(newPages.keySet());
        List<String> changedPagesUrls = new ArrayList<>();
        for (String url : joinPagesUrls) {
            if (!prevPages.get(url).equals(newPages.get(url))) {
                changedPagesUrls.add(url);
            }
        }
        return changedPagesUrls;
    }

    private void sendMessage(List<String> newPagesUrls, List<String> deletedPagesUrls, List<String> changedPagesUrls) {
        String resultMessage = String.format(
                        """
                        Здравствуйте, дорогая и.о. секретаря
                        
                        За последние сутки во вверенных Вам сайтах произошли следующие изменения:
                        
                        Исчезли следующие страницы: %s
                        Появились следующие новые страницы: %s
                        Изменились следующие страницы: %s
                        
                        С уважением,
                        автоматизированная система
                        мониторинга.
                        """,
                !deletedPagesUrls.isEmpty() ? String.join(", ", deletedPagesUrls) : NO_CHANGE,
                !newPagesUrls.isEmpty() ? String.join(", ", newPagesUrls) : NO_CHANGE,
                !changedPagesUrls.isEmpty() ? String.join(", ", changedPagesUrls) : NO_CHANGE
        );
        System.out.println(resultMessage);
    }
}
