package Book is
  type Book is private;
  MAX_AUTHOR_NAME: constant Positive := 40;
  MAX_BOOK_TITLE: constant Positive := 100;
  MAX_BOOK_PAGES: constant Positive := 100000;

  type PAGES is new Positive range 1..MAX_BOOK_PAGES;

  function createBook(author: in String; title: in String; pages: in PAGES)
  return Book
  with pre=>author'Length > 0 and title'Length > 0;

  function get_author(s: in Book)return String;

  function get_title(s: in Book) return String;

  function get_pages(s: in Book) return PAGES;

  private
  type Book is
    record
    author: String(1..MAX_AUTHOR_NAME);
    title: String(1..MAX_BOOK_TITLE);
    pages: PAGES;
  end record;
end Book;
