with Book, Ada.Text_IO;
use Book, Ada.Text_IO;

procedure Test is

  BOOK:Books;

  procedure display(s: in Books) is

  begin

    put("Author name: ");
    put_line(get_author(s));
    put("Book Title: ");
    put_line(get_title(s));
    put("Number of pages: ");
    put_line(get_pages(s));
    put_line(Positive'Image(Positive(get_pages(s))));
  end display;

begin
  BOOK:= create_book("Stephen King", "IT", "1050");
  display(BOOK);
end Test;
