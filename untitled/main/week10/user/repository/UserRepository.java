package week10.user.repository;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements CrudRepository<User> {
    private List<User> listOfUser = new ArrayList<>();

    @Override
    public User save(User entity) {
        if (entity == null) throw new IllegalArgumentException("argument entity  is null");
        User user1 = findById(entity.getId());
        if (user1 != null) {
            user1.setUsername(entity.getUsername());
            user1.setAge(entity.getAge());
            return user1;
        }
        listOfUser.add(entity);
        return entity;
    }

    @Override
    public void delete(User entity) {
        User user = findById(entity.getId());
        if (user == null) throw new EntityNotFoundException(entity);
        if (findById(entity.getId()) != null)
            listOfUser.remove(entity);
    }

    @Override
    public User findById(Long id) {
        if (id == null) throw new IllegalArgumentException("id can not be null");
        for (User user : listOfUser)
            if (user.getId() == id)
                return user;
        return null;
    }

    @Override
    public long count() {
        return listOfUser.size();
    }

    @Override
    public void deleteAll() {
        listOfUser.clear();
    }

    @Override
    public List<User> findAll() {
        return listOfUser;
    }
}
