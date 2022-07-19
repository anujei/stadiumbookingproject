export class User{
  userPassword!: string;
  emailId!: string;
  dateOfBirth!: string;
  address!: string;
  state!: string;
  city!: string;
  pinCode!: string;
  mobileNo!: string;
  name!: string;
  role!:[
    {
        roleName:"User";
        roleDescription:"user Default";
    }
]
}
