package body Books is

  function create_book
  (author: in String;
  pages: in PAGES;
  title: in String;
  return Book
  is
    BOOK:Book;

  begin
    if author'Length > MAX_AUTHOR_NAME then
      BOOK.author(1..author'Length):= author;
    end if;
    if title'Length > MAX_BOOK_TITLE then
      BOOK.title(1 .. title'Length):= title;
    end if;

    BOOK.pages := pages;
    return BOOK;
end create_book;
