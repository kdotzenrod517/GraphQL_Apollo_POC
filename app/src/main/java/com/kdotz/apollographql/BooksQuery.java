package com.kdotz.apollographql;

import com.apollographql.apollo.api.*;
import com.apollographql.apollo.api.internal.Utils;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

@Generated("Apollo GraphQL")
public final class BooksQuery implements Query<BooksQuery.Data, BooksQuery.Data, Operation.Variables> {
  public static final String OPERATION_DEFINITION = "query Books {\n"
      + "  books {\n"
      + "    __typename\n"
      + "    title\n"
      + "    author\n"
      + "  }\n"
      + "}";

  public static final String OPERATION_ID = "2fe41198a08b3eab522bb887cac6023663c77e91674b5d4d796c2fbcbfb16e97";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  public static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "Books";
    }
  };

  private final Variables variables;

  public BooksQuery() {
    this.variables = Operation.EMPTY_VARIABLES;
  }

  @Override
  public String operationId() {
    return OPERATION_ID;
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public BooksQuery.Data wrapData(BooksQuery.Data data) {
    return data;
  }

  @Override
  public Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<Data> responseFieldMapper() {
    return new Data.Mapper();
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public OperationName name() {
    return OPERATION_NAME;
  }

  public static final class Builder {
    Builder() {
    }

    public BooksQuery build() {
      return new BooksQuery();
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forList("books", "books", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable List<Book> books;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable List<Book> books) {
      this.books = books;
    }

    public @Nullable List<Book> books() {
      return this.books;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeList($responseFields[0], books, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((Book) value).marshaller());
            }
          });
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "books=" + books
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.books == null) ? (that.books == null) : this.books.equals(that.books));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (books == null) ? 0 : books.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final Book.Mapper bookFieldMapper = new Book.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final List<Book> books = reader.readList($responseFields[0], new ResponseReader.ListReader<Book>() {
          @Override
          public Book read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<Book>() {
              @Override
              public Book read(ResponseReader reader) {
                return bookFieldMapper.map(reader);
              }
            });
          }
        });
        return new Data(books);
      }
    }
  }

  public static class Book {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("title", "title", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("author", "author", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable String title;

    final @Nullable String author;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Book(@Nonnull String __typename, @Nullable String title, @Nullable String author) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.title = title;
      this.author = author;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable String title() {
      return this.title;
    }

    public @Nullable String author() {
      return this.author;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], title);
          writer.writeString($responseFields[2], author);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Book{"
          + "__typename=" + __typename + ", "
          + "title=" + title + ", "
          + "author=" + author
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Book) {
        Book that = (Book) o;
        return this.__typename.equals(that.__typename)
         && ((this.title == null) ? (that.title == null) : this.title.equals(that.title))
         && ((this.author == null) ? (that.author == null) : this.author.equals(that.author));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= __typename.hashCode();
        h *= 1000003;
        h ^= (title == null) ? 0 : title.hashCode();
        h *= 1000003;
        h ^= (author == null) ? 0 : author.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Book> {
      @Override
      public Book map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String title = reader.readString($responseFields[1]);
        final String author = reader.readString($responseFields[2]);
        return new Book(__typename, title, author);
      }
    }
  }
}
