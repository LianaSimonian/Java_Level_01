package week10.user.repository;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(User entity) {
        super(entity.toString() + " user not found");
    }
}
