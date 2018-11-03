package org.academiadecodigo.hashtronauts.server.todolist;

import java.util.HashMap;

public class TodoList {

    private int id;
    private HashMap<Integer, TodoItem> items;
    private User owner;

    public TodoList(int id){
        this.id = id;
        this.owner = null;

        initList();
    }

    /**
     * Constructs a new instance of {@code TodoList}, with a given ID and reference of the owner
     * @param id - The ID of the list
     * @param owner - A reference to the {@code User} that owns the list
     */
    public TodoList(int id, User owner){
        this.id = id;
        this.owner = owner;

        initList();
    }

    /**
     * Initializes the HashMap property of the list to be ready for use. This method is called by the constructor
     * whenever an object of this class is initialized
     */
    private void initList(){
        items = new HashMap<>();
    }

    /**
     * Lock an item on the list that is being edited
     * @param id - the id of the item
     */
    public void lockItem(int id){
        items.get(id).setLocked(true);
    }

    /**
     * Checks if an item is currently being edited
     * @param id - the id of the item
     * @return True if the item is being edited, false if it's not being edited.
     */
    public boolean canEdit(int id){
        if( items.get(id).isLocked() ){
            return false;
        }
        return true;
    }

    /**
     * Fetches the ID of the list
     * @return an int value
     */
    public int getId(){
        return id;
    }

    /**
     * Fetches all the items in the list
     * @return a HashMap containing all the items' ID and value
     */
    public HashMap<Integer, TodoItem> getItems(){
        return items;
    }

    /**
     * Fetches a reference of the list's owner
     * @return {@code owner}
     */
    public User getOwner(){
        return owner;
    }

    /**
     * Fetches an item in the list, by ID
     * @param itemId - The ID of the requested item
     * @return a {@code TodoItem} with the requested ID
     */
    public TodoItem getItem(int itemId){
        return items.get(itemId);
    }

    /**
     * Creates a new item for the list
     * @return a {@code TodoItem}
     */
    public TodoItem createItem(){
        TodoItem newItem = new TodoItem(items.size() + 1);

        items.put(items.size() +1, newItem);

        return newItem;
    }

}