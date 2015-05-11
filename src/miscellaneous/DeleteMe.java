package miscellaneous;
/**
 * This class is intented to seprate the delete-method from the insert- and update-method in the DatabaseController.
 * @author Filip
 *
 */
public class DeleteMe {
	private Object objectToDelete;

	public DeleteMe(Object objToDelete){
		this.objectToDelete = objectToDelete;
	}
	public Object getObject() {
		return objectToDelete;
	}

}
