package cz.danes.mujgraphql.one2many.repo;


import cz.danes.mujgraphql.one2many.model.PostComment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public interface PostCommentRepository extends CrudRepository<PostComment, Long> {

    /**  jiz neni nutne kdyz je one2many lazy initialize ale eager funguje pohled
     * na many prvky comments  on one post
     * */
//    public default List<PostComment> getAllById(Long id) {
//        ArrayList<PostComment> postCommentAL=new ArrayList<>();
//        Iterator<PostComment> iterator = this.findAll().iterator();
//        while (iterator.hasNext()) {
//            PostComment next = iterator.next();
//            if (next.getPostId()==id) {
//                postCommentAL.add(next);
//            }
//        }
//        return postCommentAL;
//    }

}
