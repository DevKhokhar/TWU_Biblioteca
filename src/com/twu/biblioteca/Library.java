package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Library {
    List<Book> bookList = new ArrayList<Book>();
    List<Movie> movieList = new ArrayList<Movie>();
    List<User> userList =  new ArrayList<User>();
    int loggedinUserIndex = -1;

    Library(){
        bookList.add(new Book(1, "Head First Java", 3));
        bookList.add(new Book(2, "TDD By Example", 2));
        bookList.add(new Book(3, "Head First Ruby", 2));
        movieList.add(new Movie("Sholay",1975,"Ramesh Sippy"));
        movieList.add(new Movie("Inception",2010, "Christopher Nolan", 9));
        movieList.add(new Movie("The Shawshank Redemption", 1994, "Frank Darabont", 9));
        movieList.add(new Movie("Now You See Me", 2013, "Louis Leterrier"));
        movieList.add(new Movie("I am Kalam", 2010, "Nila Madhab Panda", 8));
        movieList.add(new Movie("Top Gun", 1986, "Tony Scott", 6));
        movieList.add(new Movie("Despicable Me 2", 2013, "Pierre Coffin", 2));
        movieList.add(new Movie("Finding Nemo", 2003, "Andew Stanton", 9));
        movieList.add(new Movie("Warrior", 2011, "Gavin O'Connor", 10));
        movieList.add(new Movie("The Notebook", 2004, "Nick Cassavates"));
        movieList.add(new Movie("12 Angry Men", 1957, "Sidney Lumet", 9));
        movieList.add(new Movie("Doubt", 2008, "John Patrick Shanley", 5));
        movieList.add(new Movie("Tetro", 2009, "Francis Ford", 7));
        movieList.add(new Movie("The Man from Earth", 2007, "Richard Schenkman"));
        movieList.add(new Movie("Pi", 1998, "Darren Aronofsky", 3));
        userList.add(new User("Devangana", "111-1111", "abcdefg", "devangak@thoughtworks.com", "9999999999"));
        userList.add(new User("Peter", "111-1112", "uvwxyz", "peter@thoughtworks.com", "8888888888"));
    }


    private void viewAllBooks() {
        System.out.println("\nBookID\tBookName\t\tTotal Copies\tAvailable Copies");
        for(Book book : bookList){
            System.out.println(book.id + "\t\t" + book.name + "\t\t" + book.total + "\t\t\t" + book.available);
        }
    }


    private void reserveABook(){
        if(BibliotecaApp.userloggedin){
            Scanner sc = new Scanner(System.in);
            boolean flag = false;
            System.out.println("Enter the name of the book to be reserved");
            String bookname = sc.nextLine();
            for(Book book : bookList){
                if(book.name.equalsIgnoreCase(bookname)){
                    if(book.check_availability_of_copies()==0)
                        System.out.println("Sorry! No copies available for this book.");
                    else book.reserve();
                    flag = true;
                    break;
                }
            }
            if(!flag)
                System.out.println("Sorry, we do not have that book in our library yet!");
        }
        else
            System.out.println("Kindly login to reserve book.");
    }


    void checkMembershipDetails() {
        if(BibliotecaApp.userloggedin){
            User user = userList.get(loggedinUserIndex);
            System.out.println("Here are your membership details:");
            System.out.println("Name : " + user.name);
            System.out.println("Email address : " + user.email);
            System.out.println("Phone number : " + user.phoneno);
        }
        else
            System.out.println("Please talk to the librarian. Thank you!");
    }

    void viewAllMovies(){
        System.out.println("\nMovieName\t\tYear\t\tDirector\tRating");
        for(Movie movie : movieList){
            if(movie.rating==0)
                System.out.println(movie.name + "\t\t" + movie.year + "\t\t" + movie.director + "\t\t" + "N/A");
            else
                System.out.println(movie.name + "\t\t" + movie.year + "\t\t" + movie.director + "\t\t" + movie.rating);
        }
    }

    int login(String username, String password){
        boolean flag = false;
        for(User user: userList){
            if(username.equals(user.name)){
                if(password.equals(user.password)){
                    loggedinUserIndex = userList.indexOf(user);
                    return 0;
                }
                else
                    return 1;
            }
        }
        return 2;
    }

    void implementChoice(int choice){
        Scanner sc = new Scanner(System.in);
        switch (choice) {
            case 1: viewAllBooks();
                break;
            case 2: reserveABook();
                break;
            case 3: checkMembershipDetails();
                break;
            case 4: viewAllMovies();
                break;
            case 5:
                if(BibliotecaApp.userloggedin==false){
                    System.out.print("Username: ");
                    String username = sc.next();
                    System.out.print("\nPassword");
                    String password = sc.next();
                    int status = login(username, password);
                    if(status==0){
                        BibliotecaApp.userloggedin = true;
                        System.out.println("You are now logged in.");
                    }
                    else if(status==1)
                        System.out.println("Incorrect Password");
                    else
                        System.out.println("User not found.");
                    break;
                }
                else{
                    BibliotecaApp.userloggedin = false;
                    loggedinUserIndex = -1;
                    System.out.println("You have been logged-out successfully.");
                }
        }
    }
}
