package Utils;

import DTOs.CreateUserRequest;
import DTOs.FindUserResponse;
import DataLayer.Model.User;

public class Mapper {
        public static void toDTO(User user, FindUserResponse response){
            response.setFullName(user.getFullName());
            response.setEmail(user.getEmail());
            response.setDateOfLastPeriod(user.getDateOfLastPeriod());
            response.setLengthOfCycle(user.getLengthOfCycle());
            response.setLengthOfPeriod(user.getLengthOfPeriod());
        }

        public static User toModel(CreateUserRequest createUserRequest){
            User user = new User();
            user.setFullName(createUserRequest.getFullName());
            user.setEmail(createUserRequest.getEmail());
            user.setDateOfLastPeriod(createUserRequest.getDateOfLastPeriod());
            user.setLengthOfCycle(createUserRequest.getLengthOfCycle());
            user.setLengthOfPeriod(createUserRequest.getLengthOfPeriod());
            return user;
        }
}
