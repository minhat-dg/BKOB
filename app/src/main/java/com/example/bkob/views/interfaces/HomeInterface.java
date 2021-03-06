package com.example.bkob.views.interfaces;

import com.example.bkob.views.adapters.BookAdapter;
import com.example.bkob.views.adapters.CategoryAdapter;

public interface HomeInterface {
    void showCategory(CategoryAdapter adapter);
    void showAllBook(BookAdapter adapter);
    void loadBookInCategory(String category);
    void emptyList();
}
