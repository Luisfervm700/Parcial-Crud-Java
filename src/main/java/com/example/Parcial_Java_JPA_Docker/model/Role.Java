@Entity
@Table(name = "roles")
public class Role {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    private String name;
  
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

}
